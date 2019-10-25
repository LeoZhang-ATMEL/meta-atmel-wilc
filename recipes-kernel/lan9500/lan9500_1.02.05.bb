DESCRIPTION = "Linux Device driver for Microchip LAN95xx Family USB 2.0 to Ethernet Controller and USB Hub with Ethernet"
LICENSE = "MIT"
#SRC_URI = "http://ww1.microchip.com/downloads/en//softwarelibrary/src-lan95xx-linux/lan9500_linux_1.02.05.tar.gz"
LIC_FILES_CHKSUM = "file://version.h;md5=e35eb0251e8981bd7f2c5df7a3749fc5"
PR = "0"

inherit module

SRC_URI = "file://smsc9500.c \
	   file://smsc9500.h \
	   file://smscusbnet.c \
	   file://smscusbnet.h \
           file://ioctl_9500.h \
	   file://version.h \
           file://Makefile \
"

S = "${WORKDIR}/"

PACKAGE_ARCH = "${MACHINE_ARCH}"
