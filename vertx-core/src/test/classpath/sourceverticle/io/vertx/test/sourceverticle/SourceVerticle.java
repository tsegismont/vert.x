/*
 * Copyright (c) 2011-2019 Contributors to the Eclipse Foundation
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0, or the Apache License, Version 2.0
 * which is available at https://www.apache.org/licenses/LICENSE-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0 OR Apache-2.0
 */

package io.vertx.test.sourceverticle;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Promise;
import io.vertx.test.sourceverticle.somepackage.OtherSourceVerticle;

/**
 * @author <a href="http://tfox.org">Tim Fox</a>
 */
public class SourceVerticle extends AbstractVerticle {


  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    vertx.deployVerticle("java:" + OtherSourceVerticle.class.getName().replace('.', '/') + ".java", new DeploymentOptions())
      .onComplete(ar -> {
      if (ar.succeeded()) {
        startPromise.complete((Void) null);
      } else {
        ar.cause().printStackTrace();
      }
    });
  }
}
