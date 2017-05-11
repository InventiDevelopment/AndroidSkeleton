package cz.inventi.inventiskeleton.domain.common

import io.reactivex.Scheduler

/**
 * Created by tomas.valenta on 5/11/2017.
 */

typealias PostExecutionThread = () -> Scheduler
typealias ThreadExecutor = () -> Scheduler
