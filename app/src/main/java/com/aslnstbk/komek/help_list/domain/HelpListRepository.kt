package com.aslnstbk.komek.help_list.domain

import com.aslnstbk.komek.common.data.models.HelpNeed
import com.aslnstbk.komek.common.data.models.PersonHelp

interface HelpListRepository {

    fun getApprovedPersonHelp(
        onSuccess: (PersonHelp) -> Unit,
        onFail: () -> Unit
    )

    fun getPeopleHelp(
        onSuccess: (List<PersonHelp>) -> Unit,
        onFail: () -> Unit
    )

    fun getHelpNeedPeople(
        onSuccess: (List<HelpNeed>) -> Unit,
        onFail: () -> Unit
    )

    fun refusePersonHelp(
        personHelp: PersonHelp,
        onSuccess: () -> Unit,
        onFail: () -> Unit
    )

    fun approvePersonHelp(
        personHelp: PersonHelp,
        onSuccess: () -> Unit,
        onFail: () -> Unit
    )

    fun donePersonHelp(
        personHelp: PersonHelp,
        onSuccess: () -> Unit,
        onFail: () -> Unit
    )
}