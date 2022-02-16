/*
 * Copyright 2022 Red Hat, Inc. and/or its affiliates.
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
package org.kie.kogito.persistence.postgresql.reporting.database;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.kie.kogito.persistence.postgresql.reporting.model.JsonType;
import org.kie.kogito.persistence.postgresql.reporting.model.PostgresField;
import org.kie.kogito.persistence.postgresql.reporting.model.PostgresMapping;
import org.kie.kogito.persistence.postgresql.reporting.model.PostgresPartitionField;
import org.kie.kogito.persistence.reporting.database.Validations;

import static org.junit.jupiter.api.Assertions.assertThrows;

class PostgresValidationsTest {

    @Test
    void testValidateSourceTableIdentityFieldsBlankFieldName() {
        final PostgresField field = new PostgresField("", JsonType.STRING);
        final List<PostgresField> fields = List.of(field);
        assertThrows(IllegalArgumentException.class,
                () -> Validations.validateSourceTableIdentityFields(fields));
    }

    @Test
    void testValidateSourceTablePartitionFieldsBlankFieldName() {
        final PostgresPartitionField field = new PostgresPartitionField("", JsonType.STRING, "value");
        final List<PostgresPartitionField> fields = List.of(field);
        assertThrows(IllegalArgumentException.class,
                () -> Validations.validateSourceTablePartitionFields(fields));
    }

    @Test
    void testValidateSourceTablePartitionFieldsBlankFieldValue() {
        final PostgresPartitionField field = new PostgresPartitionField("field", JsonType.STRING, "");
        final List<PostgresPartitionField> fields = List.of(field);
        assertThrows(IllegalArgumentException.class,
                () -> Validations.validateSourceTablePartitionFields(fields));
    }

    @Test
    void testValidateTargetTableFieldsBlankSourceJsonPath() {
        final PostgresMapping mapping = new PostgresMapping("",
                new PostgresField("field", JsonType.STRING));
        final List<PostgresMapping> mappings = List.of(mapping);
        assertThrows(IllegalArgumentException.class,
                () -> Validations.validateFieldMappings(mappings));
    }

}