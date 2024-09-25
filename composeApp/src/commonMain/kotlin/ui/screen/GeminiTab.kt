package ui.screen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import cafe.adriel.voyager.navigator.tab.TabOptions
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.model.rememberScreenModel
import com.mikepenz.markdown.m3.Markdown
import com.mikepenz.markdown.m3.markdownColor
import data.GeminiApi
import dev.shreyaspatil.ai.client.generativeai.type.GenerateContentResponse
import di.HomeScreenModelProvider
import io.github.vinceglb.filekit.compose.rememberFilePickerLauncher
import io.github.vinceglb.filekit.core.PickerType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import theme.BorderColor
import theme.CodeBackground
import theme.LinkColor
import theme.PrimaryColor
import theme.TextColor
import toComposeImageBitmap
import travelbuddy.composeapp.generated.resources.Res
import travelbuddy.composeapp.generated.resources.gemini
import travelbuddy.composeapp.generated.resources.menu_profile
import travelbuddy.composeapp.generated.resources.profile_tab
import ui.component.ShimmerAnimation
import ui.component.Tabx
import ui.viewmodel.HomeScreenModel
import util.BOTTOM_NAV_SPACE

data object GeminiTab : Tabx {
    override fun defaultTitle(): StringResource = Res.string.profile_tab
    override fun defaultIcon(): DrawableResource = Res.drawable.menu_profile

    override val options: TabOptions
        @Composable
        get() {
            val title = stringResource(Res.string.profile_tab)
            val icon = painterResource(Res.drawable.menu_profile)

            return remember {
                TabOptions(
                    index = 0u,
                    title = title,
                    icon = icon
                )
            }
        }

    @Composable
    override fun Content() {
        val screenModel = HomeScreenModelProvider.homeScreenModel
        val navigator = LocalNavigator.currentOrThrow
        GeminiScreenView(navigator = navigator, viewModel = screenModel)
    }
}

@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Composable
fun GeminiScreenView(navigator: Navigator, viewModel: HomeScreenModel){
    val navigateToGemini by viewModel.navigateToGemini.collectAsState()
    var prompt by remember { mutableStateOf("") }
    if (navigateToGemini.second != null) {
        prompt = "Please search the desting by title and provide maximum information  as a tourist I want to know about the place. Here is the title: ${navigateToGemini.second?.title}"
    }
    viewModel.setBottomNavBarVisible(true)
    val api = remember { GeminiApi() }
    val coroutineScope = rememberCoroutineScope()
    var selectedImageData by remember { mutableStateOf<ByteArray?>(null) }
    var content by remember { mutableStateOf("") }
    var showProgress by remember { mutableStateOf(false) }
    var filePath by remember { mutableStateOf("") }
    var image by remember { mutableStateOf<ImageBitmap?>(null) }
    val canClearPrompt by remember { derivedStateOf { prompt.isNotBlank() } }

    Surface(modifier = Modifier.fillMaxWidth().padding(bottom = BOTTOM_NAV_SPACE)) {
        val imagePickerLauncher = rememberFilePickerLauncher(PickerType.Image) { selectedImage ->
            coroutineScope.launch {
                val bytes = selectedImage?.readBytes()
                selectedImageData = bytes
                image = bytes?.toComposeImageBitmap()
                filePath = selectedImage?.path ?: ""
            }
        }

        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxWidth().padding(16.dp)
        ) {
            Text(
                modifier = Modifier.fillMaxWidth().padding(start = 16.dp, top = 26.dp),
                text = stringResource(Res.string.gemini),
                color = TextColor,
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center
            )

            FlowRow(
                modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
            ) {
                OutlinedTextField(
                    value = navigateToGemini.second?.title ?: prompt,
                    onValueChange = { prompt = it },
                    modifier = Modifier
                        .fillMaxSize()
                        .defaultMinSize(minHeight = 52.dp),
                    label = {
                        Text(
                            text =  "Search",
                            color = TextColor,
                            style = MaterialTheme.typography.labelSmall,
                        )
                    },
                    trailingIcon = {
                        if (canClearPrompt) {
                            IconButton(
                                onClick = { prompt = "" }
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Clear,
                                    contentDescription = "Clear"
                                )
                            }
                        }
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedLabelColor = TextColor,
                        unfocusedLabelColor = TextColor,
                        focusedBorderColor = PrimaryColor,
                        unfocusedBorderColor = TextColor,
                        cursorColor = PrimaryColor,
                        focusedTextColor = TextColor,
                        unfocusedTextColor = TextColor
                    )
                )

                OutlinedButton(
                    onClick = {
                        if (prompt.isNotBlank()) {
                            coroutineScope.launch {
                                println("prompt = $prompt")
                                content = ""
                                generateContentAsFlow(api, prompt, selectedImageData)
                                    .onStart { showProgress = true }
                                    .onCompletion { showProgress = false }
                                    .collect {
                                        showProgress = false
                                        println("response = ${it.text}")
                                        content += it.text
                                    }
                            }
                        }
                    },
                    enabled = prompt.isNotBlank(),
                    modifier = Modifier
                        .padding(all = 4.dp)
                        .weight(1f)
                        .align(Alignment.CenterVertically)
                ) {
                    Text(
                        text =  "Submit",
                        color = TextColor,
                        style = MaterialTheme.typography.labelSmall,
                    )
                }

                OutlinedButton(
                    onClick = { imagePickerLauncher.launch() },
                    modifier = Modifier
                        .padding(all = 4.dp)
                        .weight(1f)
                        .align(Alignment.CenterVertically)
                ) {
                    Text(
                        text =  "Select Image",
                        color = TextColor,
                        style = MaterialTheme.typography.labelSmall,
                    )
                }
            }

            Spacer(Modifier.height(16.dp))

            image?.let { imageBitmap ->
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = BitmapPainter(imageBitmap),
                        contentDescription = "search_image",
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }

            Spacer(Modifier.height(16.dp))
            if (showProgress) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        repeat(5) {
                            ShimmerAnimation()
                        }
                    }
                }
            } else {
                SelectionContainer {
                    Markdown(
                        modifier = Modifier.fillMaxSize(),
                        content = content,
                        colors = markdownColor(
                            text = TextColor,
                            inlineCodeText = PrimaryColor,
                            dividerColor = BorderColor,
                            codeText = PrimaryColor,
                            linkText = LinkColor,
                            codeBackground = CodeBackground,
                            inlineCodeBackground = CodeBackground
                        )
                    )
                }
            }
        }
    }
}

fun generateContentAsFlow(
    api: GeminiApi,
    prompt: String,
    imageData: ByteArray? = null
): Flow<GenerateContentResponse> = imageData?.let { imageByteArray ->
    api.generateContent(prompt, imageByteArray)
} ?: run {
    api.generateContent(prompt)
}
