/**
 * Copyright (C) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.fabric8.openshift.client.handlers;

import com.squareup.okhttp.OkHttpClient;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ResourceHandler;
import io.fabric8.openshift.api.model.BuildConfig;
import io.fabric8.openshift.client.OpenShiftConfig;
import io.fabric8.openshift.client.dsl.internal.BuildConfigOperationsImpl;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;

@Component
@Service
public class BuildConfigHandler implements ResourceHandler<BuildConfig> {

  @Override
  public String getKind() {
    return BuildConfig.class.getSimpleName();
  }

  @Override
  public BuildConfig create(OkHttpClient client, Config config, String namespace, BuildConfig item) {
      return new BuildConfigOperationsImpl(client, OpenShiftConfig.wrap(config), null, namespace, null, true, item, null, null, null).create();
  }

  @Override
  public Boolean delete(OkHttpClient client, Config config, String namespace, BuildConfig item) {
      return new BuildConfigOperationsImpl(client, OpenShiftConfig.wrap(config), null, namespace, null, true, item, null, null, null).delete(item);
  }
}
