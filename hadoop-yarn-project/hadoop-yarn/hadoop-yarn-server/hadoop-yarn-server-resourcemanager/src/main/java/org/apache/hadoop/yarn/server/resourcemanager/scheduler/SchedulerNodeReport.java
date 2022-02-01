/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.hadoop.yarn.server.resourcemanager.scheduler;

import org.apache.hadoop.classification.InterfaceAudience.Private;
import org.apache.hadoop.classification.InterfaceStability.Stable;
import org.apache.hadoop.yarn.api.records.Resource;
import org.apache.hadoop.yarn.api.records.ResourceUtilization;

/**
 * Node usage report.
 */
@Private
@Stable
public class SchedulerNodeReport {
  private final Resource used;
  private final Resource avail;
  private final ResourceUtilization utilization;
  private final int num;
  
  public SchedulerNodeReport(SchedulerNode node) {
    this.used = node.getAllocatedResource();
    this.avail = node.getUnallocatedResource();
    this.num = node.getNumContainers();
    this.utilization = node.getNodeUtilization();
  }
  
  /**
   * @return the amount of resources currently used by the node.
   */
  public Resource getUsedResource() {
    return used;
  }

  /**
   * @return the amount of resources currently available on the node
   */
  public Resource getAvailableResource() {
    return avail;
  }

  /**
   * @return the number of containers currently running on this node.
   */
  public int getNumContainers() {
    return num;
  }

  /**
   *
   * @return utilization of this node
   */
  public ResourceUtilization getUtilization() {
    return utilization;
  }
}