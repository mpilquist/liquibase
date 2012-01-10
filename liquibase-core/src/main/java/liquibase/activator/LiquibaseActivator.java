/**
 * Copyright (c) 2010 Gunnar Wagenknecht and others.
 * All rights reserved.
 *
 * This program and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Gunnar Wagenknecht - initial API and implementation
 */
package liquibase.activator;

import liquibase.servicelocator.EquinoxServiceLocator;
import liquibase.servicelocator.ServiceLocator;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class LiquibaseActivator implements BundleActivator {

    private static BundleContext context;

    static BundleContext getContext() {
        return context;
    }

    public void start(BundleContext bundleContext) throws Exception {
        LiquibaseActivator.context = bundleContext;

        // set Equinox service locator
        ServiceLocator.setInstance(new EquinoxServiceLocator());
    }

    public void stop(BundleContext bundleContext) throws Exception {
        // unset Equinox service locator
        ServiceLocator.setInstance(null);

        LiquibaseActivator.context = null;
    }
}