/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.flowable.engine.impl.persistence.entity.data;

import java.util.Collection;
import java.util.List;

import org.flowable.common.engine.impl.persistence.entity.data.DataManager;
import org.flowable.engine.impl.persistence.entity.AttachmentEntity;

/**
 * @author Joram Barrez
 */
public interface AttachmentDataManager extends DataManager<AttachmentEntity> {

    List<AttachmentEntity> findAttachmentsByProcessInstanceId(String processInstanceId);

    List<AttachmentEntity> findAttachmentsByTaskId(String taskId);
    
    void bulkDeleteAttachmentsByTaskId(Collection<String> taskIds);
}
