#!/bin/bash
# Copyright (c) 2000-2016 Synology Inc. All rights reserved.

source /pkgscripts/include/pkg_util.sh

UISTRING_PATH="/source/syno-library/package/ui/texts"
description_sec="app"
description_key="description"
displayname_sec="app"
displayname_key="title"

package="syno-library"
version="0.0.0001"
maintainer="Synology Community"
arch="bromolow"

[ "$(caller)" != "0 NULL" ] && return 0
pkg_dump_info
