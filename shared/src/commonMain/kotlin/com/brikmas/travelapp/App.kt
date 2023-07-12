package com.brikmas.travelapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import dev.icerock.moko.resources.FontResource
import dev.icerock.moko.resources.ImageResource
import dev.icerock.moko.resources.StringResource
import dev.icerock.moko.resources.compose.colorResource
import dev.icerock.moko.resources.compose.fontFamilyResource
import dev.icerock.moko.resources.compose.painterResource
import dev.icerock.moko.resources.compose.readTextAsState
import dev.icerock.moko.resources.compose.stringResource
import dev.icerock.moko.resources.getImageByFileName
import org.jetbrains.compose.resources.ExperimentalResourceApi

@OptIn(ExperimentalResourceApi::class, ExperimentalMaterial3Api::class)
@Composable
internal fun App() {
    MaterialTheme(
        colorScheme = if (isSystemInDarkTheme()) darkColorScheme() else lightColorScheme()
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
                .background(color = MaterialTheme.colorScheme.background)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(SharedRes.images.moko_logo),
                contentDescription = null
            )

            var text: String by remember { mutableStateOf("") }

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth()
                    .padding(top = 16.dp),
                value = text,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = MaterialTheme.colorScheme.onBackground
                ),
                onValueChange = { text = it }
            )
            Text(
                modifier = Modifier.fillMaxWidth()
                    .padding(vertical = 8.dp),
                text = stringResource(SharedRes.strings.hello_world),
                color = colorResource(SharedRes.colors.textColor),
                fontFamily = fontFamilyResource(SharedRes.fonts.sf_pro_regular.sf_pro_regular)
            )

            Button(onClick = { text = "Hello, ${getPlatformName()}" }) {
                Text(text = stringResource(SharedRes.strings.hello_world))
            }

            val fileContent: String? by SharedRes.files.text_file.readTextAsState()
            Text(
                modifier = Modifier.padding(top = 16.dp),
                text = fileContent.orEmpty(),
                color = MaterialTheme.colorScheme.onBackground
            )


            SharedRes.files.text_file
        }
    }
}

fun getImageByName(name: String): ImageResource? {
    return SharedRes.images.getImageByFileName(name) ?: SharedRes.images.getImageByFileName(
        name.substringBeforeLast(".") //strips extension from filename
    )
}

expect fun getPlatformName(): String


