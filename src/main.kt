import org.jsoup.Jsoup

fun main(){
    val url = "https://dl.google.com/dl/android/maven2/androidx/core/group-index.xml"

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