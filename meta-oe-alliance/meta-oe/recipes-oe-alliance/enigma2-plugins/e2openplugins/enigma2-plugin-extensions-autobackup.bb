MODULE = "AutoBackup"
DESCRIPTION = "Backup settings automatically"

require openplugins-replace-pli.inc

require openplugins-setuptools3.inc

# I spent over 2 hours trying to get the shell file to be executable. Sorry, I just gave up
# and decided that this would be good enough until someone explains how to do this properly
# with setuptools3.
do_install:append() {
	chmod a+x ${D}/usr/lib/enigma2/python/Plugins/*/*/*.sh
}

require assume-gplv2.inc
