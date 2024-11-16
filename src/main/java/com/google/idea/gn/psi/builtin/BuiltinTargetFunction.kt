// Copyright (c) 2020 Google LLC All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.
package com.google.idea.gn.psi.builtin

import com.google.idea.gn.completion.CompletionIdentifier
import com.google.idea.gn.psi.*
import com.google.idea.gn.psi.Function
import com.google.idea.gn.psi.Target
import com.google.idea.gn.psi.builtin.BuiltinVariable.*
import com.google.idea.gn.psi.scope.Scope

enum class BuiltinTargetFunction(override val identifierName: String,
                                 varList: Sequence<FunctionVariable>) : Function {
  ACTION("action",
      sequenceOf(ARGS, DATA, DATA_DEPS, DEPFILE, DEPS, INPUTS, METADATA, OUTPUTS, POOL,
          RESPONSE_FILE_CONTENTS, SCRIPT, SOURCES)),
  ACTION_FOREACH("action_foreach",
      sequenceOf(ARGS, DATA, DATA_DEPS, DEPFILE, DEPS, INPUTS, METADATA, OUTPUTS, POOL,
          RESPONSE_FILE_CONTENTS, SCRIPT, SOURCES)),
  BUNDLE_DATA("bundle_data",
      sequenceOf(SOURCES, OUTPUTS, DEPS, DATA_DEPS, METADATA, PUBLIC_DEPS, VISIBILITY)),
  COPY("copy",
      sequenceOf(SOURCES, OUTPUTS)),
  CREATE_BUNDLE("create_bundle",
      sequenceOf(BUNDLE_ROOT_DIR, BUNDLE_CONTENTS_DIR, BUNDLE_RESOURCES_DIR, BUNDLE_EXECUTABLE_DIR,
          BUNDLE_DEPS_FILTER, DEPS, DATA_DEPS, PUBLIC_DEPS, VISIBILITY, PRODUCT_TYPE,
          CODE_SIGNING_ARGS, CODE_SIGNING_SCRIPT, CODE_SIGNING_SOURCES, CODE_SIGNING_OUTPUTS,
          XCODE_EXTRA_ATTRIBUTES, XCODE_TEST_APPLICATION_NAME, PARTIAL_INFO_PLIST, METADATA)),
  EXECUTABLE("executable",
      sequenceOf(CFLAGS, CFLAGS_C, CFLAGS_CC, CFLAGS_OBJC, CFLAGS_OBJCC, ASMFLAGS, DEFINES,
          INCLUDE_DIRS, INPUTS, LDFLAGS, LIB_DIRS, LIBS, PRECOMPILED_HEADER, PRECOMPILED_SOURCE,
          RUSTFLAGS, RUSTENV, DATA_DEPS, DEPS, PUBLIC_DEPS, ALL_DEPENDENT_CONFIGS, PUBLIC_CONFIGS,
          CHECK_INCLUDES, CONFIGS, DATA, FRIEND, INPUTS, METADATA, OUTPUT_NAME, OUTPUT_EXTENSION,
          PUBLIC, SOURCES, TESTONLY, VISIBILITY, ALIASED_DEPS, CRATE_ROOT, CRATE_NAME
      )),
  GENERATED_FILE("generated_file",
      sequenceOf(CONTENTS, DATA_KEYS, REBASE, WALK_KEYS, OUTPUT_CONVERSION, DATA_DEPS, DEPS,
          PUBLIC_DEPS, ALL_DEPENDENT_CONFIGS, PUBLIC_CONFIGS)),
  GROUP("group",
      sequenceOf(DEPS, DATA_DEPS, PUBLIC_DEPS, TESTONLY)),
  LOADABLE_MODULE("loadable_module",
      sequenceOf(CFLAGS, CFLAGS_C, CFLAGS_CC, CFLAGS_OBJC, CFLAGS_OBJCC, ASMFLAGS, DEFINES,
          INCLUDE_DIRS, INPUTS, LDFLAGS, LIB_DIRS, LIBS, PRECOMPILED_HEADER, PRECOMPILED_SOURCE,
          RUSTFLAGS, RUSTENV, DATA_DEPS, DEPS, PUBLIC_DEPS, ALL_DEPENDENT_CONFIGS, PUBLIC_CONFIGS,
          CHECK_INCLUDES, CONFIGS, DATA, FRIEND, INPUTS, METADATA, OUTPUT_NAME, OUTPUT_EXTENSION,
          PUBLIC, SOURCES, TESTONLY, VISIBILITY, ALIASED_DEPS, CRATE_ROOT, CRATE_NAME, CRATE_TYPE)),
  RUST_LIBRARY("rust_library",
      sequenceOf(CFLAGS, CFLAGS_C, CFLAGS_CC, CFLAGS_OBJC, CFLAGS_OBJCC, ASMFLAGS, DEFINES,
          INCLUDE_DIRS, INPUTS, LDFLAGS, LIB_DIRS, LIBS, PRECOMPILED_HEADER, PRECOMPILED_SOURCE,
          RUSTFLAGS, RUSTENV, DATA_DEPS, DEPS, PUBLIC_DEPS, ALL_DEPENDENT_CONFIGS, PUBLIC_CONFIGS,
          CHECK_INCLUDES, CONFIGS, DATA, FRIEND, INPUTS, METADATA, OUTPUT_NAME, OUTPUT_EXTENSION,
          PUBLIC, SOURCES, TESTONLY, VISIBILITY, ALIASED_DEPS, CRATE_ROOT, CRATE_NAME)),
  RUST_PROC_MACRO("rust_proc_macro",
      sequenceOf(CFLAGS, CFLAGS_C, CFLAGS_CC, CFLAGS_OBJC, CFLAGS_OBJCC, ASMFLAGS, DEFINES,
          INCLUDE_DIRS, INPUTS, LDFLAGS, LIB_DIRS, LIBS, PRECOMPILED_HEADER, PRECOMPILED_SOURCE,
          RUSTFLAGS, RUSTENV, DATA_DEPS, DEPS, PUBLIC_DEPS, ALL_DEPENDENT_CONFIGS, PUBLIC_CONFIGS,
          CHECK_INCLUDES, CONFIGS, DATA, FRIEND, INPUTS, METADATA, OUTPUT_NAME, OUTPUT_EXTENSION,
          PUBLIC, SOURCES, TESTONLY, VISIBILITY, ALIASED_DEPS, CRATE_ROOT, CRATE_NAME)),
  SHARED_LIBRARY("shared_library",
      sequenceOf(CFLAGS, CFLAGS_C, CFLAGS_CC, CFLAGS_OBJC, CFLAGS_OBJCC, ASMFLAGS, DEFINES,
          INCLUDE_DIRS, INPUTS, LDFLAGS, LIB_DIRS, LIBS, PRECOMPILED_HEADER, PRECOMPILED_SOURCE,
          RUSTFLAGS, RUSTENV, DATA_DEPS, DEPS, PUBLIC_DEPS, ALL_DEPENDENT_CONFIGS, PUBLIC_CONFIGS,
          CHECK_INCLUDES, CONFIGS, DATA, FRIEND, INPUTS, METADATA, OUTPUT_NAME, OUTPUT_EXTENSION,
          PUBLIC, SOURCES, TESTONLY, VISIBILITY, ALIASED_DEPS, CRATE_ROOT, CRATE_NAME, CRATE_TYPE)),
  SOURCE_SET("source_set",
      sequenceOf(CFLAGS, CFLAGS_C, CFLAGS_CC, CFLAGS_OBJC, CFLAGS_OBJCC, ASMFLAGS, DEFINES,
          INCLUDE_DIRS, INPUTS, LDFLAGS, LIB_DIRS, LIBS, PRECOMPILED_HEADER, PRECOMPILED_SOURCE,
          RUSTFLAGS, RUSTENV, ALL_DEPENDENT_CONFIGS, PUBLIC_CONFIGS, CHECK_INCLUDES, CONFIGS, DATA,
          FRIEND, METADATA, OUTPUT_NAME, OUTPUT_EXTENSION, PUBLIC, TESTONLY, VISIBILITY, SOURCES,
          DEPS, DATA_DEPS, PUBLIC_DEPS)),
  STATIC_LIBRARY("static_library",
      sequenceOf(COMPLETE_STATIC_LIB, CFLAGS, CFLAGS_C, CFLAGS_CC, CFLAGS_OBJC, CFLAGS_OBJCC,
          ASMFLAGS, DEFINES, INCLUDE_DIRS, INPUTS, LDFLAGS, LIB_DIRS, LIBS, PRECOMPILED_HEADER,
          PRECOMPILED_SOURCE, RUSTFLAGS, RUSTENV, DATA_DEPS, DEPS, PUBLIC_DEPS,
          ALL_DEPENDENT_CONFIGS, PUBLIC_CONFIGS, CHECK_INCLUDES, CONFIGS, DATA, FRIEND, INPUTS,
          METADATA, OUTPUT_NAME, OUTPUT_EXTENSION, PUBLIC, SOURCES, TESTONLY, VISIBILITY,
          ALIASED_DEPS, CRATE_ROOT, CRATE_NAME)),

  // NOTE: config is not really a target function, we model is as such while we don't differentiate
  // between configs and targets.
  CONFIG("config",
      sequenceOf(CFLAGS, CFLAGS_C, CFLAGS_CC, CFLAGS_OBJC, CFLAGS_OBJCC, ASMFLAGS, DEFINES,
          INCLUDE_DIRS, INPUTS, LDFLAGS, LIB_DIRS, LIBS, PRECOMPILED_HEADER, PRECOMPILED_SOURCE,
          RUSTFLAGS, RUSTENV, CONFIGS, ALL_DEPENDENT_CONFIGS, PUBLIC_CONFIGS
      ))
  ;

  override val variables: Map<String, FunctionVariable> = varList.associateBy { it.identifierName }

  override fun execute(call: GnCall, targetScope: Scope): GnValue? {
    val targetName = GnPsiUtil.evaluateFirstToString(call.exprList, targetScope) ?: return null
    var callSite = targetScope.callSite
    if (callSite == null) {
      callSite = call
    }
    targetScope.addTarget(Target(targetName, callSite))
    return null
  }

  override val isBuiltin: Boolean
    get() = true
  override val identifierType: CompletionIdentifier.IdentifierType
    get() = CompletionIdentifier.IdentifierType.TARGET_FUNCTION
}