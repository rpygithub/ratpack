/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ratpack.core.handling.internal;

import ratpack.core.handling.Context;
import ratpack.core.handling.Handler;
import ratpack.exec.registry.Registry;

public class RegistryInsertHandler implements Handler {

  private final Handler[] handler;
  private final Registry registry;

  public RegistryInsertHandler(Registry registry, Handler handler) {
    this.handler = ChainHandler.unpack(handler);
    this.registry = registry;
  }

  public void handle(Context context) {
    context.insert(registry, handler);
  }

}
