package cz.inventi.inventiskeleton.di;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by tomas.valenta on 5/11/2017.
 */

@Scope
@Documented
@Retention(RUNTIME)
public @interface ApplicationScope {
}
