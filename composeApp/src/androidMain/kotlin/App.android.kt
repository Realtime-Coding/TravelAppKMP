import android.content.Intent
import android.net.Uri
import com.travel.buddy.MuseumApp

internal actual fun openUrl(url: String?) {
    val uri = url?.let { Uri.parse(it) } ?: return
    val intent = Intent().apply {
        action = Intent.ACTION_VIEW
        data = uri
        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    }
    MuseumApp.INSTANCE.startActivity(intent)
}