package fhs.mmt.nma.pixie.ui.profile

import android.content.res.Configuration
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import fhs.mmt.nma.pixie.data.Photographer
import fhs.mmt.nma.pixie.samples.providers.UserSampleProvider
import fhs.mmt.nma.pixie.ui.theme.PixieTheme

@Composable
fun ProfileScreen(user: Photographer) {
    Text(text = "TODO: $user")
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ProfilePreview(@PreviewParameter(UserSampleProvider::class) user: Photographer) {
    PixieTheme {
        ProfileScreen(user = user)
    }
}

