/*
 * Copyright (c) 2022 Eclipse Foundation and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

package com.sun.enterprise.deployment;

import com.sun.enterprise.deployment.annotation.handlers.ContextualResourceDefinition;
import com.sun.enterprise.deployment.annotation.handlers.ManagedThreadFactoryDefinitionData;

import java.util.Properties;

import org.glassfish.deployment.common.JavaEEResourceType;


/**
 * @author David Matejcek
 */
public class ManagedThreadFactoryDefinitionDescriptor extends ResourceDescriptor
    implements ContextualResourceDefinition {

    private static final long serialVersionUID = 6376196495209425819L;

    private final ManagedThreadFactoryDefinitionData definition;

    public ManagedThreadFactoryDefinitionDescriptor() {
        this(new ManagedThreadFactoryDefinitionData(), null);
    }


    public ManagedThreadFactoryDefinitionDescriptor(ManagedThreadFactoryDefinitionData data, MetadataSource source) {
        this.definition = data;
        setResourceType(JavaEEResourceType.MTFDD);
        if (source != null) {
            setMetadataSource(source);
        }
    }


    @Override
    public String getName() {
        return this.definition.getName();
    }


    @Override
    public void setName(String name) {
        this.definition.setName(name);
    }


    @Override
    public String getContext() {
        return definition.getContext();
    }


    @Override
    public void setContext(String context) {
        definition.setContext(context);
    }


    public int getPriority() {
        return definition.getPriority();
    }


    public void setPriority(int priority) {
        definition.setPriority(priority);
    }


    public Properties getProperties() {
        return definition.getProperties();
    }


    public void setProperties(Properties properties) {
        definition.setProperties(properties);
    }


    public void addManagedThreadFactoryPropertyDescriptor(ResourcePropertyDescriptor property) {
        addManagedThreadFactoryPropertyDescriptor(property.getName(), property.getValue());
    }


    public void addManagedThreadFactoryPropertyDescriptor(String name, String value) {
        definition.addManagedThreadFactoryPropertyDescriptor(name, value);
    }


    public ManagedThreadFactoryDefinitionData getData() {
        return definition;
    }


    @Override
    public String toString() {
        return "ManagedThreadFactoryDefinitionDescriptor[definition=" + definition + ']';
    }
}
