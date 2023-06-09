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
package org.flowable.dmn.engine.impl.persistence.entity;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.flowable.common.engine.impl.persistence.entity.EntityManager;
import org.flowable.dmn.api.DmnHistoricDecisionExecution;
import org.flowable.dmn.engine.impl.HistoricDecisionExecutionQueryImpl;

/**
 * @author Tijs Rademakers
 */
public interface HistoricDecisionExecutionEntityManager extends EntityManager<HistoricDecisionExecutionEntity> {
    
    void deleteHistoricDecisionExecutionsByDeploymentId(String deploymentId);

    List<DmnHistoricDecisionExecution> findHistoricDecisionExecutionsByQueryCriteria(HistoricDecisionExecutionQueryImpl decisionExecutionQuery);

    long findHistoricDecisionExecutionCountByQueryCriteria(HistoricDecisionExecutionQueryImpl decisionExecutionQuery);
    
    List<DmnHistoricDecisionExecution> findHistoricDecisionExecutionsByNativeQuery(Map<String, Object> parameterMap);

    long findHistoricDecisionExecutionCountByNativeQuery(Map<String, Object> parameterMap);

    void delete(HistoricDecisionExecutionQueryImpl query);
    
    void bulkDeleteHistoricDecisionExecutionsByInstanceIdsAndScopeType(Collection<String> instanceIds, String scopeType);
}