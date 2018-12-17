DESCRIPTION = "Microchip ATWILC1000/3000 binary firmware"
LICENSE = "MIT"
SRC_URI = "https://github.com/linux4wilc/firmware/archive/wilc_linux_15_2_RC1.tar.gz"
LIC_FILES_CHKSUM = "file://LICENCE.wilc_fw;md5=89ed0ff0e98ce1c58747e9a39183cc9f"
PR = "0"

#S = "/at91/yocto/poky/build-microchip/tmp/work/cortexa5hf-neon-poky-linux-gnueabi/firmware-wilc/linux-0/firmware-wilc_linux_15_2_RC1/"
S = "${WORKDIR}/firmware-wilc_linux_15_2_RC1"
SRC_URI[md5sum] = "3d7887654e3e00d9ad46e27b2f9d1b27"

do_compile() {
	:
}

do_install() {
	install -d ${D}${nonarch_base_libdir}/firmware/mchp/
	cp -r * ${D}${nonarch_base_libdir}/firmware/mchp/
}

FILES_${PN} = "${nonarch_base_libdir}/firmware/mchp"
