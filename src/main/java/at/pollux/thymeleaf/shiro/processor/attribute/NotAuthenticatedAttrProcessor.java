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
package at.pollux.thymeleaf.shiro.processor.attribute;

import org.thymeleaf.Arguments;
import org.thymeleaf.dom.Element;
import org.thymeleaf.processor.attr.AbstractConditionalVisibilityAttrProcessor;

import at.pollux.thymeleaf.shiro.dialect.ShiroFacade;
import org.thymeleaf.processor.element.AbstractAttributeTagProcessor;

public class NotAuthenticatedAttrProcessor extends AbstractAttributeTagProcessor {

    public static NotAuthenticatedAttrProcessor create() {
        return new NotAuthenticatedAttrProcessor();
    }

    private static final String ATTRIBUTE_NAME = "notAuthenticated";
    private static final int PRECEDENCE = 300;

    protected NotAuthenticatedAttrProcessor() {
        super(ATTRIBUTE_NAME);
    }

    @Override
    public int getPrecedence() {
        return PRECEDENCE;
    }

    @Override
    protected boolean isVisible(final Arguments arguments, final Element element, final String attributeName) {
        return ShiroFacade.isNotAuthenticated();
    }
}