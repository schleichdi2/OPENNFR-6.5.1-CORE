SUMMARY = "Text shaping library"
DESCRIPTION = "HarfBuzz is an OpenType text shaping engine."
HOMEPAGE = "http://www.freedesktop.org/wiki/Software/HarfBuzz"
BUGTRACKER = "https://bugs.freedesktop.org/enter_bug.cgi?product=HarfBuzz"
SECTION = "libs"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=6ee0f16281694fb6aa689cca1e0fb3da \
                    file://src/hb-ucd.cc;beginline=1;endline=15;md5=29d4dcb6410429195df67efe3382d8bc \
                    "

FILESEXTRAPATHS:prepend := "${THISDIR}/harfbuzz:"

UPSTREAM_CHECK_URI = "https://github.com/${BPN}/${BPN}/releases"
UPSTREAM_CHECK_REGEX = "harfbuzz-(?P<pver>\d+(\.\d+)+).tar"

SRC_URI = "https://github.com/${BPN}/${BPN}/releases/download/${PV}/${BPN}-${PV}.tar.xz"
SRC_URI[sha256sum] = "0ada50a1c199bb6f70843ab893c55867743a443b84d087d54df08ad883ebc2cd"
SRC_URI:append:sh4 = " file://support-old-gcc.patch"

inherit meson pkgconfig lib_package gtk-doc gobject-introspection

CFLAGS:append:sh4 = " -std=gnu11"

GIR_MESON_ENABLE_FLAG = 'enabled'
GIR_MESON_DISABLE_FLAG = 'disabled'
GTKDOC_MESON_ENABLE_FLAG = 'enabled'
GTKDOC_MESON_DISABLE_FLAG = 'disabled'

PACKAGECONFIG ??= "cairo freetype glib icu"
PACKAGECONFIG[cairo] = "-Dcairo=enabled,-Dcairo=disabled,cairo"
PACKAGECONFIG[freetype] = "-Dfreetype=enabled,-Dfreetype=disabled,freetype"
PACKAGECONFIG[glib] = "-Dglib=enabled,-Dglib=disabled,glib-2.0"
PACKAGECONFIG[graphite] = "-Dgraphite=enabled,-Dgraphite=disabled,graphite2"
PACKAGECONFIG[icu] = "-Dicu=enabled,-Dicu=disabled,icu"

PACKAGES =+ "${PN}-icu ${PN}-icu-dev ${PN}-subset"

LEAD_SONAME = "libharfbuzz.so"

do_install:append() {
    # If no tools are installed due to PACKAGECONFIG then this directory is
    #still installed, so remove it to stop packaging wanings.
    rmdir --ignore-fail-on-non-empty ${D}${bindir}
}

FILES:${PN}-icu = "${libdir}/libharfbuzz-icu.so.*"
FILES:${PN}-icu-dev = "${libdir}/libharfbuzz-icu.la \
                       ${libdir}/libharfbuzz-icu.so \
                       ${libdir}/pkgconfig/harfbuzz-icu.pc \
"
FILES:${PN}-subset = "${libdir}/libharfbuzz-subset.so.*"

BBCLASSEXTEND = "native nativesdk"
