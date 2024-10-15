package di

import ui.viewmodel.HomeScreenModel

//import org.koin.core.context.startKoin
//import org.koin.dsl.module
//
//val screenModelsModule = module {
//
//}
//
//fun initKoin() {
//    startKoin {
//        modules(
//            screenModelsModule,
//        )
//    }
//}

object HomeScreenModelProvider {
    val homeScreenModel: HomeScreenModel by lazy {
        HomeScreenModel()
    }
}
