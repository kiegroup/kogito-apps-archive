/*
 * Copyright 2020 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kie.kogito.jobs.service.repository.infinispan.marshaller;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import org.infinispan.protostream.MessageMarshaller;
import org.kie.kogito.jobs.service.repository.marshaller.RecipientMarshaller;

@ApplicationScoped
public class MarshallersProducer {

    @Produces
    public MessageMarshaller jobDetailsMarshaller(RecipientMarshaller recipientMarshaller) {
        return new JobDetailsMarshaller(recipientMarshaller);
    }

    @Produces
    public MessageMarshaller triggerMarshaller() {
        return new TriggerMarshaller();
    }
}
