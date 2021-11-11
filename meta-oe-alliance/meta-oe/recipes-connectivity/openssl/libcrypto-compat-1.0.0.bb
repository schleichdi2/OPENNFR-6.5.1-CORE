SUMMARY = "Compatibility for packages that link to libcrypto or libssl 1.0.0"

require conf/license/license-gplv2.inc

RDEPENDS:${PN} = "libcrypto10 libssl10"
PV = "1.2"

RREPLACES:${PN} = "libcrypto1.0.0 libssl1.0.0"
RCONFLICTS:${PN} = "libcrypto1.0.0 libssl1.0.0"

do_install () {
    install -d ${D}${libdir}
    ln -sf libcrypto.so.1.0.2 ${D}${libdir}/libcrypto.so.1.0.0
    ln -sf libssl.so.1.0.2 ${D}${libdir}/libssl.so.1.0.0
}

FILES:${PN} = "${libdir}"

RPROVIDES:${PN} += "libcrypto1.0.0 libssl1.0.0"
