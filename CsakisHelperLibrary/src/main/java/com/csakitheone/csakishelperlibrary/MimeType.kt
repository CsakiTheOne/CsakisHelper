package com.csakitheone.csakishelperlibrary

class MimeType {
    class Text {
        companion object {
            const val PLAIN = "text/plain"
            const val RTF = "text/rtf"
            const val HTML = "text/html"
            const val JSON = "text/json"
            const val GENERIC = "text/*"
        }
    }
    class Image {
        companion object {
            const val JPG = "image/jpg"
            const val PNG = "image/png"
            const val GIF = "image/gif"
            const val GENERIC = "image/*"
        }
    }
    class Video {
        companion object {
            const val MP4 = "video/mp4"
            const val _3GP = "video/3gp"
            const val GENERIC = "video/*"
        }
    }
    class Application {
        companion object {
            const val PDF = "application/pdf"
            const val GENERIC = "application/*"
        }
    }
    companion object {
        @Deprecated("This is highly discouraged and will only match activities that are able to handle generic data streams.")
        const val GENERIC = "*/*"
    }
}