package team.uptech.playground.teststate.model

import androidx.compose.runtime.Immutable


@Immutable
class ImmutableList<T> internal constructor(list: List<T>) : List<T> by list

fun <T> List<T>.toImmutableList() = ImmutableList(this)

fun <T> immutableListOf(vararg elements: T): ImmutableList<T> = ImmutableList(listOf(*elements))
