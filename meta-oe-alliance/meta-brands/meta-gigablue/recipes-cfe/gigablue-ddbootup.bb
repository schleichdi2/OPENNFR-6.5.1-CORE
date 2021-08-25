SUMMARY = "ddbootup for ${MACHINEBUILD}"
SECTION = "base"
PRIORITY = "required"
LICENSE = "CLOSED"
require conf/license/license-close.inc
PACKAGE_ARCH = "${MACHINEBUILD}"

PV = "1.0"
PR = "r1"

S = "${WORKDIR}"

do_compile() {
}

do_install() {
    install -d ${D}${sysconfdir}/init.d
    install -d ${D}${sysconfdir}/rcS.d
    echo '#! /bin/sh' > ${WORKDIR}/ddbootup
    ${@bb.utils.contains("MACHINE_FEATURES", "gigabluelcd", "echo 'echo 1 > /proc/stb/lcd/mode' >> ${WORKDIR}/ddbootup" , "", d)}
    echo 'touch /dev/dbox/lcd0' >> ${WORKDIR}/ddbootup
    echo 'echo "${MACHINEBUILD}" > /proc/stb/info/gbmodel' >> ${WORKDIR}/ddbootup
    install -m 0755 ${WORKDIR}/ddbootup ${D}${sysconfdir}/init.d
    ${@bb.utils.contains("MACHINE", "gb7252", "ln -sf ../init.d/ddbootup ${D}${sysconfdir}/rcS.d/S66ddbootup" , "ln -sf ../init.d/ddbootup ${D}${sysconfdir}/rcS.d/S39ddbootup", d)}
}

FILES:${PN} += "${sysconfdir}"
