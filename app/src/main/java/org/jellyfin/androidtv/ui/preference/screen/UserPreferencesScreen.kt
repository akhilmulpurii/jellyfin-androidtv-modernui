package org.jellyfin.androidtv.ui.preference.screen

import org.jellyfin.androidtv.R
import org.jellyfin.androidtv.ui.preference.category.aboutCategory
import org.jellyfin.androidtv.ui.preference.dsl.OptionsFragment
import org.jellyfin.androidtv.ui.preference.dsl.link
import org.jellyfin.androidtv.ui.preference.dsl.optionsScreen
import org.jellyfin.androidtv.util.UserSwitchHelper
import org.koin.android.ext.android.inject

class UserPreferencesScreen : OptionsFragment() {
	private val userSwitchHelper: UserSwitchHelper by inject()

	override val screen by optionsScreen {
		setTitle(R.string.settings_title)

		category {
			link {
				setTitle(R.string.pref_login)
				setContent(R.string.pref_login_description)
				icon = R.drawable.ic_users
				withFragment<AuthPreferencesScreen>()
			}

			link {
				setTitle(R.string.pref_customization)
				setContent(R.string.pref_customization_description)
				icon = R.drawable.ic_adjust
				withFragment<CustomizationPreferencesScreen>()
			}

			link {
				setTitle(R.string.pref_playback)
				setContent(R.string.pref_playback_description)
				icon = R.drawable.ic_next
				withFragment<PlaybackPreferencesScreen>()
			}

			link {
				setTitle(R.string.pref_telemetry_category)
				setContent(R.string.pref_telemetry_description)
				icon = R.drawable.ic_error
				withFragment<CrashReportingPreferencesScreen>()
			}

			link {
				setTitle(R.string.pref_developer_link)
				setContent(R.string.pref_developer_link_description)
				icon = R.drawable.ic_flask
				withFragment<DeveloperPreferencesScreen>()
			}

			action {
				setTitle(R.string.lbl_switch_user)
				content = getString(R.string.pref_switch_user_description)
				icon = R.drawable.ic_switch_users

				onActivate = {
					activity?.let { userSwitchHelper.switchUser(it) }
				}
			}
		}

		aboutCategory()
	}
}
