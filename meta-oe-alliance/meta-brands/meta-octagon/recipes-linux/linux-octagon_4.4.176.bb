DESCRIPTION = "Linux kernel for ${MACHINE}"
SECTION = "kernel"
LICENSE = "GPLv2"

KERNEL_RELEASE = "4.4.176"
SRCDATE = "20220302"

inherit kernel machine_kernel_pr

MACHINE_KERNEL_PR:append = "0"


SRC_URI[md5sum] = "96c57616c9e0121a57b34c93e6453824"
SRC_URI[sha256sum] = "fd113f78998a63702e6e0ea62e9133d7865edb0e5172f79ab2779c5ae850fb71"

LIC_FILES_CHKSUM = "file://${WORKDIR}/linux-${PV}/COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

# By default, kernel.bbclass modifies package names to allow multiple kernels
# to be installed in parallel. We revert this change and rprovide the versioned
# package names instead, to allow only one kernel to be installed.
PKG:${KERNEL_PACKAGE_NAME}-base = "kernel-base"
PKG:${KERNEL_PACKAGE_NAME}-image = "kernel-image"
RPROVIDES:${KERNEL_PACKAGE_NAME}-base = "kernel-${KERNEL_VERSION}"
RPROVIDES:${KERNEL_PACKAGE_NAME}-image = "kernel-image-${KERNEL_VERSION}"

SRC_URI += "http://source.mynonpublic.com/octagon/octagon-linux-${PV}-${SRCDATE}.tar.gz \
    file://defconfig \
    file://initramfs-subdirboot.cpio.gz;unpack=0 \
    file://initramfs.cpio.gz;unpack=0 \ 
    file://findkerneldevice.sh \
    file://fix-multiple-defs-yyloc.patch \
"

S = "${WORKDIR}/linux-${PV}"
B = "${WORKDIR}/build"

export OS = "Linux"
KERNEL_OBJECT_SUFFIX = "ko"
KERNEL_IMAGEDEST = "tmp"

KERNEL_EXTRA_ARGS = "EXTRA_CFLAGS=-Wno-attribute-alias"

FILES:${KERNEL_PACKAGE_NAME}-image = "${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE} /${KERNEL_IMAGEDEST}/findkerneldevice.sh"

KERNEL_IMAGETYPE = "uImage"
KERNEL_OUTPUT = "arch/${ARCH}/boot/${KERNEL_IMAGETYPE}"

kernel_do_configure:prepend() {
	install -d ${B}/usr
	install -m 0644 ${WORKDIR}/initramfs-subdirboot.cpio.gz ${B}/
	install -m 0644 ${WORKDIR}/initramfs.cpio.gz ${B}/
}

kernel_do_install:append() {
	install -d ${D}/${KERNEL_IMAGEDEST}
	install -m 0755 ${KERNEL_OUTPUT} ${D}/${KERNEL_IMAGEDEST}
	install -m 0755 ${WORKDIR}/findkerneldevice.sh ${D}${KERNEL_IMAGEDEST}
}

pkg_postinst:kernel-image () {
    if [ "x$D" == "x" ]; then
        if [ -f /${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE} ] ; then
            /${KERNEL_IMAGEDEST}/./findkerneldevice.sh
            dd if=/${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE} of=/dev/kernel
        fi
    fi
    true
}

do_rm_work() {
}
