package org.jellyfin.androidtv.util

import android.content.Intent
import androidx.fragment.app.FragmentActivity
import org.jellyfin.androidtv.auth.repository.SessionRepository
import org.jellyfin.androidtv.ui.playback.MediaManager
import org.jellyfin.androidtv.ui.startup.StartupActivity

class UserSwitchHelper(
	private val mediaManager: MediaManager,
	private val sessionRepository: SessionRepository
) {
	fun switchUser(activity: FragmentActivity) {
		mediaManager.clearAudioQueue()
		sessionRepository.destroyCurrentSession()

		val selectUserIntent = Intent(activity, StartupActivity::class.java).apply {
			putExtra(StartupActivity.EXTRA_HIDE_SPLASH, true)
			addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
		}

		activity.startActivity(selectUserIntent)
		activity.finishAfterTransition()
	}
}
