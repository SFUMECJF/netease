import pandas as pd
from subsceneAPI import subtitle


movies = pd.read_csv("movie_metadata.csv")
movie_titles = movies["movie_title"]
print(movie_titles)
#%%
# sub = subtitle.search(title="extraction",year="2020",language="english",limit="2")
sub = subtitle.search(title="extraction",year="2020",language="korean",limit="2")
# sub = subtitle.search(title="extraction",year="2020",language="japanese",limit="2")
print(sub.ZIPlinks) # or obj.showZIPlinks()
sub.downloadZIP()