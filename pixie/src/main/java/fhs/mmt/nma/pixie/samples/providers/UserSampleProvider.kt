package fhs.mmt.nma.pixie.samples.providers

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import fhs.mmt.nma.pixie.data.User
import fhs.mmt.nma.pixie.samples.FakeUsers
import fhs.mmt.nma.pixie.samples.IvanCujic

class UserSampleProvider: PreviewParameterProvider<User> {
    override val values: Sequence<User>
        get() = sequenceOf(IvanCujic, FakeUsers.first())
}