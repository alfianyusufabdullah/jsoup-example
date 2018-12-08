import org.jsoup.Jsoup

fun main(){

    urls.forEach { url ->
        val result = Jsoup.connect(url).execute()
        val dom = result.parse().allElements

        dom.forEach {
            val tag = it.tagName()
            if (tag.contains("-ktx")){
                val versions = it.attr("versions")
                val lastVersion = versions.split(",").last()

                println("last version of $tag is $lastVersion")
            }
        }
    }
}

val urls = listOf(
    "https://dl.google.com/dl/android/maven2/androidx/core/group-index.xml",
    "https://dl.google.com/dl/android/maven2/androidx/fragment/group-index.xml",
    "https://dl.google.com/dl/android/maven2/androidx/palette/group-index.xml",
    "https://dl.google.com/dl/android/maven2/androidx/sqlite/group-index.xml",
    "https://dl.google.com/dl/android/maven2/androidx/collection/group-index.xml",
    "https://dl.google.com/dl/android/maven2/androidx/lifecycle/group-index.xml",
    "https://dl.google.com/dl/android/maven2/android/arch/navigation/group-index.xml",
    "https://dl.google.com/dl/android/maven2/android/arch/work/group-index.xml"
)