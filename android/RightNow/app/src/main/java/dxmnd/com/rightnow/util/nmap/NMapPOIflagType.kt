package dxmnd.com.rightnow.util.nmap


class NMapPOIflagType {
    companion object {
        val UNKNOWN = 0x0000

        // Single POI Icons
        private val SINGLE_POI_BASE = 0x0100

        // Spot, Pin icons
        val SPOT = SINGLE_POI_BASE + 1
        val PIN = SPOT + 1

        // Direction POI icons: From, To
        private val DIRECTION_POI_BASE = 0x0200
        val FROM = DIRECTION_POI_BASE + 1
        val TO = FROM + 1

        // end of single marker icon
        val SINGLE_MARKER_END = 0x04FF

        // Direction Number icons
        private val MAX_NUMBER_COUNT = 1000
        val NUMBER_BASE = 0x1000 // set NUMBER_BASE + 1 for '1' number
        val NUMBER_END = NUMBER_BASE + MAX_NUMBER_COUNT


        // Custom POI icons
        private val MAX_CUSTOM_COUNT = 1000
        val CUSTOM_BASE = NUMBER_END
        val CUSTOM_END = CUSTOM_BASE + MAX_CUSTOM_COUNT

        // Clickable callout에 보여지는 화살표
        val CLICKABLE_ARROW = CUSTOM_END + 1

        fun isBoundsCentered(markerId: Int): Boolean {
            var boundsCentered = false

            if (markerId >= NMapPOIflagType.NUMBER_BASE && markerId < NMapPOIflagType.NUMBER_END) {
                boundsCentered = true
            }

            return boundsCentered
        }

        fun getMarkerId(poiFlagType: Int, iconIndex: Int): Int {

            return poiFlagType + iconIndex
        }

        fun getPOIflagType(markerId: Int): Int {
            var poiFlagType = UNKNOWN

            // Alphabet POI icons
            when {
                markerId in NUMBER_BASE..(NUMBER_END - 1) -> // Direction Number icons
                    poiFlagType = NUMBER_BASE
                markerId in CUSTOM_BASE..(CUSTOM_END - 1) -> // Custom POI icons
                    poiFlagType = CUSTOM_BASE
                markerId > SINGLE_POI_BASE -> poiFlagType = markerId
            }

            return poiFlagType
        }

        fun getPOIflagIconIndex(markerId: Int): Int {
            var iconIndex = 0

            when {
                markerId in NUMBER_BASE..(NUMBER_END - 1) -> // Direction Number icons
                    iconIndex = markerId - (NUMBER_BASE + 1)
                markerId in CUSTOM_BASE..(CUSTOM_END - 1) -> // Custom POI icons
                    iconIndex = markerId - (CUSTOM_BASE + 1)
                markerId > SINGLE_POI_BASE -> iconIndex = 0
            }

            return iconIndex
        }

    }
}