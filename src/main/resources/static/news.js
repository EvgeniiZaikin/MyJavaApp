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

function parseNews() {
    const button = document.getElementById("parse-button");
    button.textContent = "...";

    fetch("/news/api/parse", {
          method: 'POST',
          headers: {
            'Content-type': 'application/json'
          },
    }).then((response) => {
        location.reload();
    }).catch((error) => {
        alert(error);
    }).finally(() => {
        button.textContent = "Парсинг новостей";
    });
}