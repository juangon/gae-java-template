/*
 * Copyright 2013, Rogue.IO
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package rogue.app.framework.support.fileupload;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;

/**
 * Factory for creating in-memory file items.
 */
public class InMemoryFileItemFactory implements FileItemFactory
{
    private static final int DEFAULT_THRESHOLD = 2000000;

    private int threshold;

    public InMemoryFileItemFactory()
    {
        this(DEFAULT_THRESHOLD);
    }

    public InMemoryFileItemFactory(int threshold)
    {
        this.threshold = threshold;
    }

    @Override
    public FileItem createItem(String fieldName, String contentType, boolean isFormField, String fileName)
    {
        return new InMemoryFileItem(fieldName, contentType, isFormField, fileName, threshold);
    }
}
