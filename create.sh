#!/bin/bash

PACKAGE_NAME=${PACKAGE_NAME:-syno-library}
PACKAGE_VERSION=${PACKAGE_VERSION:-0.0.0005}
TOOLKIT_FOLDER=${TOOLKIT_FOLDER:-/opt/toolkit}
DSM_VERSION=${DSM_VERSION:-6.1}
PACKAGE_MAINTAINER=${PACKAGE_MAINTAINER:-Synology Community}
NAS_ARCH=${NAS_ARCH:-bromolow}
PACKAGE_CENTER_DESC=${PACKAGE_CENTER_DESC:-This is a wonderful Synology package}
PACKAGE_CENTER_TITLE=${PACKAGE_CENTER_TITLE:-My wonderful package for Synology}

RED="\e[31m"
GREEN="\e[32m"
NORMAL="\e[0m"

function result {
    status=$1
    
    if [ $status -eq 0 ];
    then
      echo -e "${GREEN} -> Ok${NORMAL}"
    else
      echo -e "${RED} -> Not OK${NORMAL}"
    fi
}

# whomai
user_id=`id -u`

if [ $user_id != 0 ];
then
    echo "Only root user can execute this script"
    exit 1
fi

if [ -z "${TOOLKIT_FOLDER// }" ];
then
    echo "The toolkit folder could not be empty"
    exit 1
fi

if [ -z "${PACKAGE_NAME// }" ];
then
    echo "The package name could not be empty"
    exit 1
fi

if [ -d $TOOLKIT_FOLDER ];
then
    echo -ne "Removing previous folder"
    #rm -rf $TOOLKIT_FOLDER
    result $?
fi

# Creation of toolkit folders
echo -ne "Creating folder ${TOOLKIT_FOLDER}/source/${PACKAGE_NAME}/package/ui/images"
mkdir -p ${TOOLKIT_FOLDER}/source/${PACKAGE_NAME}/package/ui/images
result $?

echo -ne "Creating folder ${TOOLKIT_FOLDER}/source/${PACKAGE_NAME}/package/ui/texts/{enu,fre}"
mkdir -p ${TOOLKIT_FOLDER}/source/${PACKAGE_NAME}/package/ui/texts/{enu,fre}
result $?

echo -ne "Creating folder ${TOOLKIT_FOLDER}/source/${PACKAGE_NAME}/scripts"
mkdir -p ${TOOLKIT_FOLDER}/source/${PACKAGE_NAME}/scripts
result $?

echo -ne "Creating folder ${TOOLKIT_FOLDER}/source/${PACKAGE_NAME}/SynoBuildConf"
mkdir -p ${TOOLKIT_FOLDER}/source/${PACKAGE_NAME}/SynoBuildConf
result $?

# Change to the newly created directory
cd $TOOLKIT_FOLDER

# Download of synology toolchain
echo -ne "Downloading pkgscripts toolkit"
git clone https://github.com/SynologyOpenSource/pkgscripts-ng &> /tmp/syno-pkg.log 
result $?

# Creation of build environment
echo -ne "Building dev environment"
./pkgscripts-ng/EnvDeploy -v ${DSM_VERSION} -p ${NAS_ARCH} &> /tmp/syno-pkg.log 
result $?

# Change to package image directory
cd ${TOOLKIT_FOLDER}/source/${PACKAGE_NAME}/package/ui/images

# Download of images
echo -ne "Downloading default icon 256px"
wget -q http://icons.iconarchive.com/icons/martin-berube/animal/256/wolf-icon.png --output-document ${PACKAGE_NAME}_256.png
result $?

echo -ne "Downloading default icon 256->144px"
wget -q http://icons.iconarchive.com/icons/martin-berube/animal/256/wolf-icon.png --output-document ${PACKAGE_NAME}_144.png
result $?

echo -ne "Downloading default icon 128px"
wget -q http://icons.iconarchive.com/icons/martin-berube/animal/128/wolf-icon.png --output-document ${PACKAGE_NAME}_128.png
result $?

echo -ne "Downloading default icon 128->72px"
wget -q http://icons.iconarchive.com/icons/martin-berube/animal/128/wolf-icon.png --output-document ${PACKAGE_NAME}_72.png
result $?

echo -ne "Downloading default icon 64px"
wget -q http://icons.iconarchive.com/icons/martin-berube/animal/64/wolf-icon.png --output-document ${PACKAGE_NAME}_64.png
result $?

echo -ne "Downloading default icon 48px"
wget -q http://icons.iconarchive.com/icons/martin-berube/animal/48/wolf-icon.png --output-document ${PACKAGE_NAME}_48.png
result $?

echo -ne "Downloading default icon 48->36px"
wget -q http://icons.iconarchive.com/icons/martin-berube/animal/48/wolf-icon.png --output-document ${PACKAGE_NAME}_36.png
result $?

echo -ne "Downloading default icon 32px"
wget -q http://icons.iconarchive.com/icons/martin-berube/animal/32/wolf-icon.png --output-document ${PACKAGE_NAME}_32.png
result $?

echo -ne "Downloading default icon 24px"
wget -q http://icons.iconarchive.com/icons/martin-berube/animal/24/wolf-icon.png --output-document ${PACKAGE_NAME}_24.png
result $?

echo -ne "Downloading default icon 16px"
wget -q http://icons.iconarchive.com/icons/martin-berube/animal/16/wolf-icon.png --output-document ${PACKAGE_NAME}_16.png
result $?

echo -ne "Copying default icon 256px"
cp ${PACKAGE_NAME}_256.png ../../../PACKAGE_ICON_256.PNG
result $?

echo -ne "Copying default icon 72px"
cp ${PACKAGE_NAME}_72.png ../../../PACKAGE_ICON.PNG    
result $?

# Change to package image directory
cd ${TOOLKIT_FOLDER}/source/${PACKAGE_NAME}/package/ui/texts
echo -ne "Creating enu text file"
cat << __EOF__ > ./enu/strings
[app]
title = "$PACKAGE_NAME"
description = "$PACKAGE_NAME"
__EOF__
result $?

echo -ne "Creating fre text file"
cat << __EOF__ > ./fre/strings
[app]
title = "$PACKAGE_NAME"
description = "$PACKAGE_NAME"
__EOF__
result $?

cd ${TOOLKIT_FOLDER}/source/${PACKAGE_NAME}/

# Creation of script files (empty currently)
echo -ne "Creating postinst script"
echo -e '#!/bin/sh\nexit 0' > ./scripts/postinst
result $?

echo -ne "Creating postuninst script"
echo -e '#!/bin/sh\nexit 0' > ./scripts/postuninst
result $?

echo -ne "Creating postupgrade script"
echo -e '#!/bin/sh\nexit 0' > ./scripts/postupgrade
result $?

echo -ne "Creating preinst script"
echo -e '#!/bin/sh\nexit 0' > ./scripts/preinst
result $?

echo -ne "Creating preuninst script"
echo -e '#!/bin/sh\nexit 0' > ./scripts/preuninst
result $?

echo -ne "Creating preupgrade script"
echo -e '#!/bin/sh\nexit 0' > ./scripts/preupgrade
result $?

echo -ne "Creating start-stop-status script"
echo -e '#!/bin/sh\nexit 0' > ./scripts/start-stop-status
result $?

# script fils must be executable
echo -ne "Make scripts executable"
chmod +x ./scripts/*
result $?

# Creation of  files used to generate package 
# "build" file
echo -ne "Creating build script"
echo 'exit 0' > ./SynoBuildConf/build
result $?

# "depends" file
echo -ne "Creating depends script"
cat << __EOF__ > ./SynoBuildConf/depends
[BuildDependent]
# each line here is a dependent project

[ReferenceOnly]
# each line here is a project for reference only but no need to be built

[default]
all="${DSM_VERSION}"   # toolkit environment version of specific platform. (all platform use 5.2 toolkit environment)
__EOF__
result $?

# "INFO.sh" file
echo -ne "Creating INFO batch script"
cat << __EOF__ > ./INFO.sh
#!/bin/bash
# Copyright (c) 2000-2016 Synology Inc. All rights reserved.

source /pkgscripts/include/pkg_util.sh

UISTRING_PATH="/source/${PACKAGE_NAME}/package/ui/texts"
# Avec la version 6.1, la description et le nom sont obligatoire. Cependant, ces informations ne sont plus 
# générées à partir des clés ci-dessous. Il faut donc les écrire manuellement (le temps de trouver pourquoi
# et comment remédier à ce problème).
description_sec="app"
description_key="description"
displayname_sec="app"
displayname_key="title"
# A mettre manuellement pour le moment
displayname=syno-library
description=syno-library

package="${PACKAGE_NAME}"
version="${PACKAGE_VERSION}"
maintainer="${PACKAGE_MAINTAINER}"
arch="\$(pkg_get_platform)"

[ "\$(caller)" != "0 NULL" ] && return 0
pkg_dump_info
__EOF__
result $?

# INFO.sh must be executable
echo -ne "Make INFO.sh executable"
chmod +x INFO.sh
result $?

# "install" file
echo -ne "Creating install script"
cat << __EOF__ > ./SynoBuildConf/install
#!/bin/bash
# Copyright (C) 2000-2016 Synology Inc. All rights reserved.

### Use PKG_DIR as working directory.
PKG_DIR=/tmp/_test_spk
rm -rf \$PKG_DIR
mkdir -p \$PKG_DIR

### get spk packing functions
source /pkgscripts/include/pkg_util.sh

create_package_tgz() {
    local fireware_version=
    local package_tgz_dir=/tmp/_package_tgz

    ### clear destination directory
    if [ -d \$package_tgz_dir ];
    then
      rm -r \$package_tgz_dir
    fi

    mkdir -p \$package_tgz_dir

    cp -R package/* \$package_tgz_dir

    ### create package.tgz \$1: source_dir \$2: dest_dir
    pkg_make_package \$package_tgz_dir "\${PKG_DIR}"
}

create_spk(){
    local conf_dir=\$PKG_DIR/conf
    local scripts_dir=\$PKG_DIR/scripts

    ### Copy Package Center scripts to PKG_DIR
    mkdir -p \$scripts_dir
    cp -av scripts/* \$scripts_dir

    ### Copy package icon
    cp -av PACKAGE_ICON*.PNG \$PKG_DIR

    ### Generate INFO file
    ./INFO.sh > INFO
    cp INFO \$PKG_DIR/INFO

    ### Create the final spk.
    # pkg_make_spk <source path> <dest path> <spk file name>
    # Please put the result spk into /image/packages
    # spk name functions: pkg_get_spk_name pkg_get_spk_unified_name pkg_get_spk_family_name
    mkdir -p /image/packages
    pkg_make_spk \${PKG_DIR} "/image/packages" ${PACKAGE_NAME}-${PACKAGE_VERSION}.spk
}

main() {
    create_package_tgz
    create_spk
}

main "\$@"
__EOF__
result $?

# Generate package
cd ${TOOLKIT_FOLDER}

echo -ne "Generation of synology package"
./pkgscripts-ng/PkgCreate.py -x0 -S -c ${PACKAGE_NAME} &> /tmp/syno-pkg.log
result $?
