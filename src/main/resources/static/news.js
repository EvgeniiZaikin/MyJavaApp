function updateNewsStatus(newsId, status) {
    fetch("/news/api/" + newsId + "/" + status, {
          method: 'PUT',
          headers: {
            'Content-type': 'application/json'
          },
    }).then((response) => {
        location.reload();
    }).catch((error) => {
        alert(error);
    });
}