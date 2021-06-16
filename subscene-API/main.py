from subsceneAPI import subtitle
# sub = subtitle.search(title="extraction",year="2020",language="english",limit="2")
sub = subtitle.search(title="extraction",year="2020",language="korean",limit="2")
# sub = subtitle.search(title="extraction",year="2020",language="japanese",limit="2")
print(sub.ZIPlinks) # or obj.showZIPlinks()
sub.downloadZIP()