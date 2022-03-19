package org.kolodyazhni.assignment.core.utils

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers

fun <T> Observable<T>.observeOnMainThread(): Observable<T> = observeOn(AndroidSchedulers.mainThread())