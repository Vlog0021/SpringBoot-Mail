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
package org.flowable.task.service.impl.persistence.entity.data;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.flowable.common.engine.impl.persistence.entity.data.DataManager;
import org.flowable.task.api.history.HistoricTaskInstance;
import org.flowable.task.service.impl.HistoricTaskInstanceQueryImpl;
import org.flowable.task.service.impl.persistence.entity.HistoricTaskInstanceEntity;
import org.flowable.task.service.impl.persistence.entity.TaskEntity;

/**
 * @author Joram Barrez
 */
public interface HistoricTaskInstanceDataManager extends DataManager<HistoricTaskInstanceEntity> {

    HistoricTaskInstanceEntity create(TaskEntity task);

    List<HistoricTaskInstanceEntity> findHistoricTasksByParentTaskId(String parentTaskId);
    
    List<String> findHistoricTaskIdsByParentTaskIds(Collection<String> parentTaskIds);

    List<HistoricTaskInstanceEntity> findHistoricTasksByProcessInstanceId(String processInstanceId);
    
    List<String> findHistoricTaskIdsForProcessInstanceIds(Collection<String> processInstanceIds);
    
    List<String> findHistoricTaskIdsForScopeIdsAndScopeType(Collection<String> scopeIds, String scopeType);

    long findHistoricTaskInstanceCountByQueryCriteria(HistoricTaskInstanceQueryImpl historicTaskInstanceQuery);

    List<HistoricTaskInstance> findHistoricTaskInstancesByQueryCriteria(HistoricTaskInstanceQueryImpl historicTaskInstanceQuery);

    List<HistoricTaskInstance> findHistoricTaskInstancesAndRelatedEntitiesByQueryCriteria(HistoricTaskInstanceQueryImpl historicTaskInstanceQuery);

    List<HistoricTaskInstance> findHistoricTaskInstancesByNativeQuery(Map<String, Object> parameterMap);

    long findHistoricTaskInstanceCountByNativeQuery(Map<String, Object> parameterMap);

    void deleteHistoricTaskInstances(HistoricTaskInstanceQueryImpl historicTaskInstanceQuery);
    
    void bulkDeleteHistoricTaskInstancesForIds(Collection<String> taskIds);
    
    void deleteHistoricTaskInstancesForNonExistingProcessInstances();
    
    void deleteHistoricTaskInstancesForNonExistingCaseInstances();
}
