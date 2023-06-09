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
package org.flowable.cmmn.engine.impl.persistence.entity;

import java.util.Collection;
import java.util.List;

import org.flowable.cmmn.api.history.HistoricMilestoneInstance;
import org.flowable.cmmn.api.history.HistoricMilestoneInstanceQuery;
import org.flowable.common.engine.impl.persistence.entity.EntityManager;

/**
 * @author Joram Barrez
 */
public interface HistoricMilestoneInstanceEntityManager extends EntityManager<HistoricMilestoneInstanceEntity> {
    
    HistoricMilestoneInstanceQuery createHistoricMilestoneInstanceQuery();

    List<HistoricMilestoneInstance> findHistoricMilestoneInstancesByQueryCriteria(HistoricMilestoneInstanceQuery query);

    long findHistoricMilestoneInstanceCountByQueryCriteria(HistoricMilestoneInstanceQuery query);
    
    void bulkDeleteHistoricMilestoneInstancesForCaseInstanceIds(Collection<String> caseInstanceIds);
    
    void deleteHistoricMilestoneInstancesForNonExistingCaseInstances();
}