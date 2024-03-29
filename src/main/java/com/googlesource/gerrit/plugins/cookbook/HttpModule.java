// Copyright (C) 2013 The Android Open Source Project
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.googlesource.gerrit.plugins.cookbook;

import com.google.gerrit.extensions.registration.DynamicSet;
import com.google.gerrit.extensions.webui.GwtPlugin;
import com.google.gerrit.extensions.webui.JavaScriptPlugin;
import com.google.gerrit.extensions.webui.WebUiPlugin;
import com.google.gerrit.httpd.plugins.HttpPluginModule;

public class HttpModule extends HttpPluginModule {
  @Override
  protected void configureServlets() {
    serve("/say-hello/*").with(HelloWorldServlet.class);
    DynamicSet.bind(binder(), WebUiPlugin.class)
        .toInstance(new JavaScriptPlugin("greetings.js"));
    DynamicSet.bind(binder(), WebUiPlugin.class)
        .toInstance(new JavaScriptPlugin("hello-change.js"));
    DynamicSet.bind(binder(), WebUiPlugin.class)
        .toInstance(new JavaScriptPlugin("hello-project.js"));
    DynamicSet.bind(binder(), WebUiPlugin.class)
        .toInstance(new JavaScriptPlugin("hello-revision.js"));
    DynamicSet.bind(binder(), WebUiPlugin.class)
        .toInstance(new GwtPlugin("cookbook"));
  }
}
