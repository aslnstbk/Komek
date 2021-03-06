package com.aslnstbk.komek.navigation

import com.aslnstbk.komek.ask_help.presentation.AskHelpFragment
import com.aslnstbk.komek.auth.presentation.AuthFragment
import com.aslnstbk.komek.base_flow.BaseFlowFragment
import com.aslnstbk.komek.common.data.models.PersonHelp
import com.aslnstbk.komek.help_list.presentation.HelpListFragment
import com.aslnstbk.komek.help_need.presentation.HelpNeedFragment
import com.aslnstbk.komek.home.presentation.HomeFragment
import com.aslnstbk.komek.person_help.presentation.PersonHelpFragment
import com.aslnstbk.komek.profile.presentation.ProfileFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
    fun Auth() = FragmentScreen { AuthFragment() }
    fun BaseFlow() = FragmentScreen { BaseFlowFragment() }
    fun Home() = FragmentScreen { HomeFragment() }
    fun Profile() = FragmentScreen { ProfileFragment() }
    fun AskHelp() = FragmentScreen { AskHelpFragment() }
    fun HelpList(isHorizontal: Boolean = false) = FragmentScreen {
        HelpListFragment(isHorizontal)
    }
    fun HelpNeed(helpNeedId: String) = FragmentScreen { HelpNeedFragment(helpNeedId) }
    fun PersonHelp(personHelp: PersonHelp) = FragmentScreen { PersonHelpFragment(personHelp) }
}