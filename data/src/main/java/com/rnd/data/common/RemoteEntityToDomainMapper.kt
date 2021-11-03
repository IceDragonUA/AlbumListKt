package com.rnd.data.common

interface RemoteEntityToDomainMapper<in T, out R> {

    fun map(input: T?): R
}
