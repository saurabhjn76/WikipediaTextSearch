# Wikipedia Distributed Search

An app which will download results of a search query from Wikipedia using a distributed network. Different parts of the data will be downloaded on different devices and then the whole data will be synced together to form the complete dataset. 

## Implementation Details


### App init and Phone connection feature

In this phase, we will first initialize the app.
Then we will add a basic UI to it and the feature to make phones connect and work together as a group. This group will be later responsible for downloading data distributively. 


### Distributed Wikipedia download feature

In this phase, we will add the feature to download data from Wikipedia. The work will be divided by the node which behaves as the central server. It will see the number of client nodes and based on that, it will divide the work like, articles starting from A-C go in Client 1, D-F go in Client 2 and so on.

### Distributed Search Feature 

In this phase, there would be several steps : 
1. The client would send a request to server for the query to be searched.
2. Server would send the request to all the clients to start searching.
3. Clients would respond to the server with the articles containing the search keyword.
4. Server would pass on the results to the client which made the request.

### References
[Official documentation on Wikipedia Download](https://en.wikipedia.org/wiki/Wikipedia:Database_download)
[Latest dump data](https://dumps.wikimedia.org/other/static_html_dumps/current/)
