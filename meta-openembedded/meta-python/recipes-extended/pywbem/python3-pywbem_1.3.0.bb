SUMMARY = "Python WBEM Client and Provider Interface"
DESCRIPTION = "\
A Python library for making CIM (Common Information Model) operations over \
HTTP using the WBEM CIM-XML protocol. It is based on the idea that a good \
WBEM client should be easy to use and not necessarily require a large amount \
of programming knowledge. It is suitable for a large range of tasks from \
simply poking around to writing web and GUI applications. \
\
WBEM, or Web Based Enterprise Management is a manageability protocol, like \
SNMP, standardised by the Distributed Management Task Force (DMTF) available \
at http://www.dmtf.org/standards/wbem. \
\
It also provides a Python provider interface, and is the fastest and easiest \
way to write providers on the planet."
HOMEPAGE = "http://pywbem.github.io"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=fbc093901857fcd118f065f900982c24"

SRC_URI[sha256sum] = "5df0af28f81891a3914a12f3a30b11b1981f7b30e09c5a42c011797e7fce9b6a"

inherit pypi setuptools3 update-alternatives

DEPENDS += " \
    ${PYTHON_PN}-ply-native \
    ${PYTHON_PN}-pyyaml-native \
    ${PYTHON_PN}-six-native \
    ${PYTHON_PN}-wheel-native \
"

RDEPENDS:${PN}:class-target += "\
    ${PYTHON_PN}-datetime \
    ${PYTHON_PN}-io \
    ${PYTHON_PN}-netclient \
    ${PYTHON_PN}-ply \
    ${PYTHON_PN}-pyyaml \
    ${PYTHON_PN}-six \
    ${PYTHON_PN}-stringold \
    ${PYTHON_PN}-threading \
    ${PYTHON_PN}-unixadmin \
    ${PYTHON_PN}-xml \
    ${PYTHON_PN}-nocasedict \
    ${PYTHON_PN}-nocaselist \
    ${PYTHON_PN}-yamlloader \
"

ALTERNATIVE:${PN} = "mof_compiler"
ALTERNATIVE_TARGET[mof_compiler] = "${bindir}/mof_compiler"

ALTERNATIVE_PRIORITY = "60"

BBCLASSEXTEND = "native"
