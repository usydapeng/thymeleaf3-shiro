/*****************************************************************************
 * Copyright (c) 2013, theborakompanioni (http://www.example.org)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 ****************************************************************************/
package org.zunpeng.thymeleaf.shiro.processor.element;

import org.zunpeng.thymeleaf.shiro.dialect.ShiroFacade;
import org.thymeleaf.Arguments;
import org.thymeleaf.dom.Element;
import org.thymeleaf.processor.element.AbstractElementTagProcessor;

public class AuthenticatedElementProcessor extends AbstractElementTagProcessor {

    public static AuthenticatedElementProcessor create() {
        return new AuthenticatedElementProcessor();
    }

    private static final String ELEMENT_NAME = "authenticated";
    private static final int PRECEDENCE = 300;

    protected AuthenticatedElementProcessor() {
        super(ELEMENT_NAME);
    }

    @Override
    public int getPrecedence() {
        return PRECEDENCE;
    }

    @Override
    public boolean removeHostElementIfVisible(final Arguments arguments, final Element element) {
        return true;
    }

    @Override
    public boolean isVisible(final Arguments arguments, final Element element) {
        return ShiroFacade.isAuthenticated();
    }
}
