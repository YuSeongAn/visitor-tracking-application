import http from 'k6/http';
import { sleep, check } from 'k6';

export let options = {
    vus: 1000,
    duration: '120s',
};

function getRandomSiteRootPath() {
    let randomSiteNumber = Math.floor(Math.random() * 9999999) + 1;
    return `test${randomSiteNumber}`;
}

export default function () {
    let siteRootPath = getRandomSiteRootPath();

    let response = http.post(`http://numble.com:8080/site/visitor?siteRootPath=${siteRootPath}`);

    check(response, {
        'is status 200': (r) => r.status === 200,
    });

    sleep(1);
}