SUMMARY = "showiframe for beyonwiz Model ${MACHINE}"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "CLOSED"
PACKAGE_ARCH = "${MACHINE_ARCH}"

COMPATIBLE_MACHINE = "^(beyonwizv2)$"

SRCDATE = "20180301"

PV = "${SRCDATE}"
PR = "r0"

RPROVIDES:${PN}  = "showiframe"
RREPLACES:${PN}  = "showiframe"
RCONFLICTS:${PN} = "showiframe"

SRC_URI = "http://source.mynonpublic.com/beyonwiz/${MACHINE}-showiframe-${SRCDATE}.tar.gz"

S = "${WORKDIR}"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/showiframe ${D}/${bindir}
}

do_package_qa() {
}

INHIBIT_PACKAGE_STRIP = "1"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
FILES:${PN}  = "${bindir}/showiframe"

SRC_URI[md5sum] = "898ccb22efbcc90123fdc9c1d794b078"
SRC_URI[sha256sum] = "8c691126d8d505c3943ebbcf55a50adfef6a38787d2d255863c4a43362f527a3"
