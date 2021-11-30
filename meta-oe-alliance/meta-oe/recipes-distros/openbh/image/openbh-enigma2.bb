SUMMARY = "OpenBh Enigma2"
MAINTAINER = "OpenBh"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

ALLOW_EMPTY:${PN} = "1"
PACKAGES = "${PN}"

PV = "${IMAGE_VERSION}"
PR = "r16"

inherit packagegroup

RCONFLICTS:${PN} = "enigma2-plugin-extensions-permanenttimeshift enigma2-plugin-systemplugins-skinselector"
RREPLACES:${PN} = "enigma2-plugin-extensions-permanenttimeshift enigma2-plugin-systemplugins-skinselector"

RDEPENDS:${PN} = "\
    enigma2-skindefault \
    openbh-core \
    "

RRECOMMENDS:${PN} = " \
    enigma-kernel-module \
    enigma2-plugin-extensions-autotimer \
    enigma2-plugin-extensions-cutlisteditor \
    enigma2-plugin-extensions-epgimport \
    enigma2-plugin-extensions-epgrefresh \
    enigma2-plugin-extensions-epgsearch \
    enigma2-plugin-extensions-imdb \
    enigma2-plugin-extensions-mediaplayer \
    enigma2-plugin-extensions-socketmmi \
    enigma2-plugin-systemplugins-crossepg \
    enigma2-plugin-systemplugins-hotplug \
    ${@bb.utils.contains("MACHINE_FEATURES", "videoenhancement", "", "enigma2-plugin-systemplugins-videoenhancement", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "uianimation", "enigma2-plugin-systemplugins-animationsetup" , "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "osdanimation", "enigma2-plugin-systemplugins-animationsetup" , "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "omb", "enigma2-plugin-extensions-openmultiboot", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "omb", "openmultiboot", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "quadpip", "enigma2-plugin-systemplugins-quadpip", "", d)} \
    ${@bb.utils.contains("TARGET_ARCH", "arm", "glibc-compat", "", d)} \
    openbh-picon-feed-opkg-conf \
    "

